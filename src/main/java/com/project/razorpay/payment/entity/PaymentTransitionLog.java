package com.project.razorpay.payment.entity;

import com.project.razorpay.common.enums.PaymentEvent;
import com.project.razorpay.common.enums.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment-transition_log")
public class PaymentTransitionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status", length = 50)
    private PaymentStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "event", nullable = false, length = 50)
    private PaymentEvent event;


    @Enumerated(EnumType.STRING)
    @Column(name = "to_status", nullable = false, length = 50)
    private PaymentStatus toStatus;

    @Column(name = "actor", length = 50)
    private String actor;

    @Column(name = "occured_at", nullable = false)
    private LocalDateTime occurredAt;

}
