package com.example.parking_car.service.customer;

import com.example.parking_car.model.Customer;
import com.example.parking_car.repository.ICustomerRepo;
import javax.mail.MessagingException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepo customerRepo;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void create(Customer customer) {
        String randomCode = RandomString.make(64);
        customer.setVerificationCode(randomCode);
        customer.setEnabled(false);
        customerRepo.save(customer);
    }

    @Override
    public void sendVerificationEmail(Customer customer, String siteURL) throws MessagingException, UnsupportedEncodingException, javax.mail.MessagingException {
        String toAddress = customer.getEmail();
        String fromAddress = "lsyh31@gmail.com";
        String senderName = "YanHua.";
        String subject = "XÁC NHẬN EMAIL ĐĂNG KÍ TÀI KHOẢN";
        String content = "\n" +
                "<body >\n" +
                "<table style=\"background: url('https://firebasestorage.googleapis.com/v0/b/chat-messenger-air.appspot.com/o/images%2FIMG_5704.jpg?alt=media&token=13a74a6f-2ca8-4ef3-86d2-ff2dcbefc8d4') no-repeat center center;background-size: cover;\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"800\">\n" +
                "    <tr>\n" +
                "        <td style=\"width: 50px;padding-left: 70px;padding-top: 20px\">\n" +
                "            <img src=\"https://firebasestorage.googleapis.com/v0/b/chat-messenger-air.appspot.com/o/images%2FYH.png?alt=media&token=12209efc-1993-4e63-9fd4-86cbe9e4479c\" style=\"border-radius: 100%;width: 100px;\"></td>\n" +
                "        <td><span style=\"float: left;padding-left: 10px; font-size: 60px;line-height: 1;font-weight: 700;letter-spacing: 2px;text-transform: uppercase;\n" +
                "    color: #ffffff\">YanHua<span style=\"color: #ffc451\">.</span></span>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td></td>\n" +
                "        <td>\n" +
                "            <p style=\"color: #ffffff;padding-top: 0\">Chào bạn <span style=\"color: #ffc451;font-size: 14px;font-weight: bold; text-transform: capitalize;\">&nbsp;"+ customer.getName() +"</span></p>\n" +
                "            <p style=\"color: #ffffff\">\n" +
                "                Chúng tôi xin chân thành cảm ơn bạn đã đăng ký tài khoản tại <span style=\"padding-left: 5px; font-size: 20px;font-weight: 700;text-transform: uppercase;\n" +
                "    color: #ffffff\">YanHua<span style=\"color: #ffc451\">.</span></span> &nbsp; Để hoàn tất quá trình đăng ký và\n" +
                "                đảm bảo tính bảo mật của tài khoản, vui lòng xác nhận địa chỉ email của bạn bằng cách nhấp vào liên kết\n" +
                "                dưới đây:\n" +
                "            </p>\n" +
                "        <br>";
        String verifyURL="http://"+ siteURL + "/verify/"+customer.getVerificationCode();
        content += "<button style=\"text-transform: uppercase;background-color:  #ffc451;border: none; color: #ffffff;padding: 16px 32px;text-align: center;text-decoration: none;\n" +
                "             display: inline-block;font-size: 16px; margin: 4px 2px;justify-content: center;transition-duration: 0.4s; cursor: pointer; border-radius: 10px\">\n" +
                "                <a href=\"" + verifyURL + "\">Xác nhận</a></button>";
        content += "<p style=\"font-style: italic; color: #ffffff;font-size: 14px\"> Xin lưu ý rằng liên kết xác nhận này sẽ chỉ có hiệu lực trong vòng 24 giờ kể từ khi bạn nhận được email\n" +
                "                này. Sau khi xác nhận thành công, bạn có thể tiếp tục sử dụng tài khoản của mình và truy cập vào tất cả\n" +
                "                các tính năng của website.\n" +
                "                Nếu bạn không thực hiện yêu cầu xác nhận này, vui lòng bỏ qua email này.</p>\n" +
                "        </td>\n" +
                "</table>\n" +
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
    public boolean verify(String verificationCode) {
        Customer customer = customerRepo.findByVerificationCode(verificationCode);
        Calendar cal = Calendar.getInstance();
        if (customer == null) {
            return false;
        }else if((customer.getExpiryDate().getTime()- cal.getTime().getTime()) <= 0){
            customerRepo.delete(customer);
            return false;
        }else {
//            customer.setVerificationCode(null);
            customer.setEnabled(true);
            customerRepo.save(customer);
            return true;
        }
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepo.findByEmail(email);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.save(customer);
    }


}
