package erivelto.system.AluguelCarros.dto;

public record ExceptionDTO(
        String endpoint,
        int status,
        String error,
        String detail
) {

    public ExceptionDTO(String endpoint, int status, String error, String detail) {
        this.endpoint = endpoint;
        this.status = status;
        this.error = error;
        this.detail = detail;
    }
}
