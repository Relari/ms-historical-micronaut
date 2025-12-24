package pe.francovargas.dao.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.francovargas.model.domain.Currency;
import pe.francovargas.model.domain.TransactionType;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="transaction")
public class TransactionEntity implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@Column(name="amount")
	private Double amount;
	@Column(name="currency")
	@Enumerated(EnumType.STRING)
	private Currency currency;
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	@Column(name="creation_date")
	private String creationDate;
	@Column(name="id_account")
	private Integer idAccount;

}