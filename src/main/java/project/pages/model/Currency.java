package project.pages.model;

public enum Currency {
    EUR, USD, GBP;

    public String sign() {
        if (this == EUR) {
            return "€";
        } else if (this == USD) {
            return "$";
        } else {
            return "£";
        }
    }
}
