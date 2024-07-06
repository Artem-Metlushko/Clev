package ru.clevertec.check.dto;

public class ConnectionDto {
    private String dataSourceUrl;
    private String dataSourceUserName;
    private String dataSourcePassword;

    ConnectionDto(String dataSourceUrl, String dataSourceUserName, String dataSourcePassword) {
        this.dataSourceUrl = dataSourceUrl;
        this.dataSourceUserName = dataSourceUserName;
        this.dataSourcePassword = dataSourcePassword;
    }

    public static ConnectionDtoBuilder builder() {
        return new ConnectionDtoBuilder();
    }

    public static class ConnectionDtoBuilder {
        private String dataSourceUrl;
        private String dataSourceUserName;
        private String dataSourcePassword;

        ConnectionDtoBuilder() {
        }

        public ConnectionDtoBuilder dataSourceUrl(String dataSourceUrl) {
            this.dataSourceUrl = dataSourceUrl;
            return this;
        }

        public ConnectionDtoBuilder dataSourceUserName(String dataSourceUserName) {
            this.dataSourceUserName = dataSourceUserName;
            return this;
        }

        public ConnectionDtoBuilder dataSourcePassword(String dataSourcePassword) {
            this.dataSourcePassword = dataSourcePassword;
            return this;
        }

        public ConnectionDto build() {
            return new ConnectionDto(this.dataSourceUrl, this.dataSourceUserName, this.dataSourcePassword);
        }

        public String toString() {
            return "ConnectionDto.ConnectionDtoBuilder(dataSourceUrl=" + this.dataSourceUrl + ", dataSourceUserName=" + this.dataSourceUserName + ", dataSourcePassword=" + this.dataSourcePassword + ")";
        }
    }
}
