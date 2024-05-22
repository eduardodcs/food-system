package com.fiap.soat.foodsystem.adapter;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClienteDTO {
    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 números")
    private String cpf;

    @NotBlank(message = "Nome não pode ser vazio")
    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 3, max = 80, message = "Nome deve ter entre 3 e 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Nome deve conter apenas letras")
    private String nome;

    @NotBlank(message = "Telefone não pode ser vazio")
    @NotNull(message = "Telefone não pode ser nulo")
    @Size(min = 13, max = 14, message = "Telefone deve ter entre 13 e 14 caracteres")
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone precisa estar no formato (XX)XXXXX-XXXX (9 dígitos) ou (XX)XXXX-XXXX (8 dígitos)")
    private String telefone;

    @NotBlank(message = "Endereço não pode ser vazio")
    @NotNull(message = "Endereço não pode ser nulo")
    @Size(min = 5, max = 80, message = "Endereço deve ter entre 5 e 80 caracteres")
    private String endereco;

    @NotBlank(message = "E-mail não pode ser vazio")
    @NotNull(message = "E-mail não pode ser nulo")
    @Email(message = "E-mail precisa ser válido")
    private String email;

}
