package com.oficina.oficinacarro.dto;

import com.oficina.oficinacarro.model.StatusModel;
import com.oficina.oficinacarro.model.VeiculoModel;

public class VeiculoStatusDTO {
    private VeiculoModel veiculo;
    private StatusModel status;

    public VeiculoStatusDTO(VeiculoModel veiculo, StatusModel status) {
        this.veiculo = veiculo;
        this.status = status;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }

    public StatusModel getStatus() {
        return status;
    }

    public void setStatus(StatusModel status) {
        this.status = status;
    }
}
