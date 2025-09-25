package com.proway.api_intermediary.dtos;

import jakarta.validation.constraints.*;

public class EquipamentoCreateDTO {
        @NotBlank(message = "O nome é obrigatório")
        private String nome;

        @NotBlank(message = "O tipo é obrigatório")
        private String tipo;

        @NotBlank(message = "A marca é obrigatória")
        private String marca;

        @Size(max = 50, message = "O modelo deve ter no máximo 50 caracteres")
        private String modelo;

        private String numeroSerie;

        private String status;

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getNumeroSerie() {
            return numeroSerie;
        }

        public void setNumeroSerie(String numeroSerie) {
            this.numeroSerie = numeroSerie;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
}