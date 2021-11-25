class FormattedText {
    private final String text;
    private final boolean isUnderlined;
    
    FormattedText(String text) {
        this.text = text;
        this.isUnderlined = false;
    }
    
    /*
     * Overloaded constructor, but made private to prevent
     * clients from calling it directly.
     */
    private FormattedText(String text, boolean isUnderlined) {
        this.text = text;
        this.isUnderlined = isUnderlined;
    }
    
    FormattedText toggleUnderline() {
        return new FormattedText(this.text, !this.isUnderlined);
    }
    
    @Override
    public String toString() {
        if (this.isUnderlined) {
            return this.text + "(underlined)";
        } else {
            return this.text;
        }
    }
}    
