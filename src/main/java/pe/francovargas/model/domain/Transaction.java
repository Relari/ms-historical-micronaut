package pe.francovargas.model.domain;

import io.micronaut.core.annotation.Creator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private Double amount;
	private String currency;
	private String type;
	private String creationDate;
	private Integer idAccount;

}
