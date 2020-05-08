/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author edube
 */
public class ModelSolicitacaoGC {
    private int codSolicitacao;
    private int codEnergisa;
    private String nomeEnergisa;
    private int CDC;
    private int codCliente;
    private String nomeCliente;
    private int codServico;
    private String servico;
    private int codGrupo;
    private String grupo;
    private String dataSolicitacao;
    private String dataEncaminhamento;
    private int codResponsavel;
    private String Responsavel;
    private int SLA_D_U;
    private int codSituacao;
    private String situacao;
    private String dataResposta;
    private int demAnteriorPonta;
    private int demAnteriorForaPonta;
    private int demSolicitadaPonta;
    private int demSolicitadaForaPonta;
    private String observacao;
    private String Prioridade;
    private String dataLimite;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSLA_D_U() {
        return SLA_D_U;
    }

    public void setSLA_D_U(int SLA_D_U) {
        this.SLA_D_U = SLA_D_U;
    }

    public String getNomeEnergisa() {
        return nomeEnergisa;
    }

    public void setNomeEnergisa(String nomeEnergisa) {
        this.nomeEnergisa = nomeEnergisa;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getPrioridade() {
        return Prioridade;
    }

    public void setPrioridade(String Prioridade) {
        this.Prioridade = Prioridade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String obervacao) {
        this.observacao = obervacao;
    }

    public int getCDC() {
        return CDC;
    }

    public void setCDC(int CDC) {
        this.CDC = CDC;
    }

    public int getCodSolicitacao() {
        return codSolicitacao;
    }

    public void setCodSolicitacao(int codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    public int getCodEnergisa() {
        return codEnergisa;
    }

    public void setCodEnergisa(int codEnergisa) {
        this.codEnergisa = codEnergisa;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getDataEncaminhamento() {
        return dataEncaminhamento;
    }

    public void setDataEncaminhamento(String dataEncaminhamento) {
        this.dataEncaminhamento = dataEncaminhamento;
    }

    public int getCodResponsavel() {
        return codResponsavel;
    }

    public void setCodResponsavel(int codResponsavel) {
        this.codResponsavel = codResponsavel;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String Responsavel) {
        this.Responsavel = Responsavel;
    }

    public int getCodSituacao() {
        return codSituacao;
    }

    public void setCodSituacao(int codSituacao) {
        this.codSituacao = codSituacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(String dataResposta) {
        this.dataResposta = dataResposta;
    }

    public int getDemAnteriorPonta() {
        return demAnteriorPonta;
    }

    public void setDemAnteriorPonta(int demAnteriorPonta) {
        this.demAnteriorPonta = demAnteriorPonta;
    }

    public int getDemAnteriorForaPonta() {
        return demAnteriorForaPonta;
    }

    public void setDemAnteriorForaPonta(int demAnteriorForaPonta) {
        this.demAnteriorForaPonta = demAnteriorForaPonta;
    }

    public int getDemSolicitadaPonta() {
        return demSolicitadaPonta;
    }

    public void setDemSolicitadaPonta(int demSolicitadaPonta) {
        this.demSolicitadaPonta = demSolicitadaPonta;
    }

    public int getDemSolicitadaForaPonta() {
        return demSolicitadaForaPonta;
    }

    public void setDemSolicitadaForaPonta(int demSolicitadaForaPonta) {
        this.demSolicitadaForaPonta = demSolicitadaForaPonta;
    }

}
