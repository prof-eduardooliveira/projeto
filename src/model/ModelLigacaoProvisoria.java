/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Nielson Soares
 */
public class ModelLigacaoProvisoria {
    private int codSolicitacao;
    private String dataSolicitacao;
    private int codAgrupamento;
    private int codEntrada;
    private String numOficio;
    private String evento;
    private int codCidade;
    private String dataInicio;
    private String dataFim;
    private int tipoLigacao;
    private int amperagem;
    private String trafoKva;
    private String enderecoLigacao;
    private String referencia;

    public int getCodSolicitacao() {
        return codSolicitacao;
    }

    public void setCodSolicitacao(int codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getCodAgrupamento() {
        return codAgrupamento;
    }

    public void setCodAgrupamento(int codAgrupamento) {
        this.codAgrupamento = codAgrupamento;
    }

    public int getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(int codEntrada) {
        this.codEntrada = codEntrada;
    }

    public String getNumOficio() {
        return numOficio;
    }

    public void setNumOficio(String numOficio) {
        this.numOficio = numOficio;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public int getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getTipoLigacao() {
        return tipoLigacao;
    }

    public void setTipoLigacao(int tipoLigacao) {
        this.tipoLigacao = tipoLigacao;
    }

    public int getAmperagem() {
        return amperagem;
    }

    public void setAmperagem(int amperagem) {
        this.amperagem = amperagem;
    }

    public String getTrafoKva() {
        return trafoKva;
    }

    public void setTrafoKva(String trafoKva) {
        this.trafoKva = trafoKva;
    }

    public String getEnderecoLigacao() {
        return enderecoLigacao;
    }

    public void setEnderecoLigacao(String enderecoLigacao) {
        this.enderecoLigacao = enderecoLigacao;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
}
