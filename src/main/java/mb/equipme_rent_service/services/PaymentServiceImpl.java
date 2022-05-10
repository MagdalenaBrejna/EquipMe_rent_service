package mb.equipme_rent_service.services;

import mb.equipme_rent_service.domain.Payment;
import mb.equipme_rent_service.domain.Rental;
import mb.equipme_rent_service.repositories.PaymentRepository;
import mb.equipme_rent_service.web.mappers.PaymentMapper;
import mb.equipme_rent_service.web.model.PaymentDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private PaymentMapper mapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper mapper) {
        this.paymentRepository = paymentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> payments = new ArrayList<>();
        paymentRepository.findAll().forEach(payments::add);
        return payments;
    }

    @Override
    public Payment findById(UUID paymentUUID) {
        return paymentRepository.findById(paymentUUID).orElse(null);
    }

    @Override
    public Payment save(Payment newPayment) {
        return paymentRepository.save(newPayment);
    }

    @Override
    public void delete(Payment paymentToDelete) {
        paymentRepository.delete(paymentToDelete);
    }

    @Override
    public void deleteById(UUID paymentUUID) {
        paymentRepository.deleteById(paymentUUID);
    }

    @Override
    public void payForRental(Rental rental) {
        Payment payment = Payment.builder().paymentDate(LocalDateTime.now()).paymentAmount(rental.getRentalPrice()).rental(rental).build();
        save(payment);
    }

    @Override
    public List<PaymentDto> getPayments(UUID userId) {
        return convertPaymentsToPaymentsDto(paymentRepository.findByUserId(userId));
    }

    @Override
    public List<PaymentDto> getPaymentsIncome(UUID userId) {
        return convertPaymentsToPaymentsDto(paymentRepository.findIncomeByUserId(userId));
    }

    @Override
    public List<PaymentDto> getPaymentsRental(UUID userId) {
        return convertPaymentsToPaymentsDto(paymentRepository.findRentalByUserId(userId));
    }

    private List<PaymentDto> convertPaymentsToPaymentsDto(List<Payment> payments) {
        return payments.stream()
                .map(payment -> mapper.paymentToPaymentDto(payment))
                .collect(Collectors.toList());
    }
}
