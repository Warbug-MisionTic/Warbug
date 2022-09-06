package com.misiontic.warbug.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private Enum_RoleName role;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    //Inyección de dependencias
    @ManyToOne
    @JoinColumn(name = "id_enterprise",nullable = false, foreignKey = @ForeignKey(name="fk_detail_enterprise"))
    private Enterprise enterprise;

    /*
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
*/

/*    @OneToOne(mappedBy="employee",fetch = FetchType.LAZY)
    private Profile profile;*/

    @Column(length = 50, nullable = false)
    private String password;

}
