package br.com.cbyk.enums;

public enum SituacaoEnum {

    PAGA("Conta paga"),
    AGUARDANDO("Conta aguardando pagamento"),
    CANCELADA("Conta cancelada");

    private final String value;

    SituacaoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
