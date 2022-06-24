package com.futstack.Model;

public enum Operacao {
    entrada_por_doacao(0) , saida_por_doacao(1), entrada_por_nota_fiscal(2),  saida_por_nota_fiscal(3),transferencia(4);

    public int tipoOperacao;
        Operacao(int operacao) {
        tipoOperacao = operacao;
    }
    public int getTipoOperacao(){
        return tipoOperacao;
        }
        
}
