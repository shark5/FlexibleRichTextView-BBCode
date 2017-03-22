package com.daquexian.flexiblerichtextview;

@SuppressWarnings("WeakerAccess")
public abstract class Attachment {
    public abstract String getText();
    public abstract boolean isImage();
    public abstract String getAttachmentId();

    public String getUrl() {
        return "";
    }
}
