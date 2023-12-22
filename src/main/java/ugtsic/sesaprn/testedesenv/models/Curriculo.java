package ugtsic.sesaprn.testedesenv.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Properties;

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

    private String arquivo;

    private String ipAddress;

    private LocalDateTime submissionDateTime;

}
