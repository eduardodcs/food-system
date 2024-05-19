package com.fiap.soat.foodsystem.adapter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDTO {
    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String cpf;

    @NotBlank(message = "Nome não pode ser vazio")
    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 3, max = 80, message = "Nome deve ter entre 3 e 80 caracteres")
    private String nome;

    @NotBlank(message = "Telefone não pode ser vazio")
    @NotNull(message = "Telefone não pode ser nulo")
    @Size(min = 10, max = 11, message = "Telefone deve ter entre 10 e 11 caracteres")
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone precisa estar no formato (XX)XXXXX-XXXX (9 dígitos) ou (XX)XXXX-XXXX (8 dígitos)")
    private String telefone;

    @NotBlank(message = "Endereço não pode ser vazio")
    @NotNull(message = "Endereço não pode ser nulo")
    @Size(min = 5, max = 80, message = "Endereço deve ter entre 5 e 80 caracteres")
    private String endereco;

}
