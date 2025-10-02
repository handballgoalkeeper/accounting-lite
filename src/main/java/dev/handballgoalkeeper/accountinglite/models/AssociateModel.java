package dev.handballgoalkeeper.accountinglite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "associates")
public class AssociateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "associate_type_id", nullable = false)
    private AssociateTypeModel associateType;
    @Column(name = "display_name", nullable = false)
    private String displayName;
    @Column(name = "tax_id", length = 20)
    private String taxId;
    private String email;
    @Column(name = "phone", length = 50)
    private String phone;
    @Lob
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "city", length = 100)
    private String city;
    @Column(name = "state", length = 100)
    private String state;
    @Column(name = "postal_code", length = 20)
    private String postalCode;
    @Column(name = "country", length = 100)
    private String country;
    @Column(name = "created_at", nullable = false)
    private java.time.LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private java.time.LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = java.time.LocalDateTime.now();
        this.updatedAt = java.time.LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = java.time.LocalDateTime.now();
    }
}
