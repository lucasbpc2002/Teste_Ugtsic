package ugtsic.sesaprn.testedesenv.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cargo_desejado;

    private String escolaridade;

    private String observacoes;

    @Lob
    private byte[] file;

    private String ipAddress;

    private LocalDateTime submissionDateTime;

}
