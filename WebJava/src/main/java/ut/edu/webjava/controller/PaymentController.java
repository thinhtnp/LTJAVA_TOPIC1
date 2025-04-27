//package ut.edu.webjava.controller;
//
//import ut.edu.webjava.dto.PaymentRequest;
//import ut.edu.webjava.dto.PaymentResponse;
//import ut.edu.webjava.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/payment")
//public class PaymentController {
//    @Autowired
//    private PaymentService paymentService;
//
//    @PostMapping("/process")
//    public PaymentResponse processPayment(@RequestBody PaymentRequest paymentRequest) {
//        return paymentService.processPayment(paymentRequest);
//    }
//}