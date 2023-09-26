package com.example.parking_car.service.reservation;

import com.example.parking_car.model.Reservation;
import com.example.parking_car.repository.IReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    private IReservationRepo reservationRepo;

    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void create(Reservation reservation) {
        reservationRepo.save(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepo.findAll();
    }

    @Override
    public Optional<Reservation> getReservation(Long id) {
        return reservationRepo.findById(id);
    }

    @Override
    public Page<Reservation> history(Long id, Pageable pageable) {

        return reservationRepo.findByAccount_IdOrderByStartTimeDesc(id,pageable);
    }

    @Override
    public Optional<Reservation> confirmQR(String idCard, Long slotId, Long total, String numberPlate, String start, String end,Long floor) {
        return reservationRepo.findByIdCardContainingAndParkingSlot_IdAndTotalPriceAndNumberPlateAndStartTimeAndEndTimeAndParkingSlotFloorParking_Id(idCard, slotId, total, numberPlate, start, end,floor);
    }

    @Override
    public void sendQR(String qr,String email) throws MessagingException, UnsupportedEncodingException {
        String toAddress = email;
        String fromAddress = "lsyh31@gmail.com";
        String senderName = "YanHua.";
        String subject = "MÃ QR XÁC NHẬN VÀO BÃI ĐỖ";
        String content = "<body>\n" +
                "\n" +
                "    <p style=\"text-align:center;padding-left: 420px;width: 510px;font-size: 18px\">Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi! <br/> Quý khách vui lòng sử dụng  mã QR này để xác nhận khi đến bãi đỗ xe <span\n" +
                "        style=\"font-size: 20px;font-family: 'Open Sans', sans-serif\">\n" +
                "    YANHUA<span style=\"color: #ffc451\">.</span></span></p>\n" +
                "    <div style=\"width: 380px;\n" +
                "    margin: 30px auto;\n" +
                "    box-shadow: 0 20px 40px -14px rgba(0, 0, 0, 0.75);\n" +
                "    border-radius: 25px;\n" +
                "    border: 1px solid rgba(0, 0, 0, 0.75);\">\n" +
                "        <div style=\"    background: #000000;\n" +
                "    width: 320px;\n" +
                "    padding: 20px 30px;\n" +
                "    border-radius: 25px 25px 0 0;\n" +
                "    display: flex;\">\n" +
                "            <img style=\"border-radius: 100%;width: 70px;height: 70px;\" src=\"YH.png\">\n" +
                "            <div style=\"width:100%\"><p\n" +
                "                    style=\"text-align:center;color: white;padding-top: 15px;padding-left: 7px;font-size: 40px;margin: 0;font-family: 'Open Sans', sans-serif\">\n" +
                "                YANHUA<span style=\"color: #ffc451\">.</span></p></div>\n" +
                "        </div>\n" +
                "        <div style=\"    width: 300px;\n" +
                "    height: 300px;\n" +
                "    margin: 30px auto;\n" +
                "    text-align: center;\n" +
                "    display: flex;\n" +
                "    align-items: center;\n" +
                "    justify-content: center;\">\n" +
                "            <img src=\""+qr+"\"/>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "</body>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    @Override
    public List<Reservation> findByIdFloorAndStartAndEnd(Long id, String start, String end) {
        return reservationRepo.findByParkingSlot_FloorParking_IdAndStartTimeContainingAndEndTimeContaining(id, start, end);
    }
}
