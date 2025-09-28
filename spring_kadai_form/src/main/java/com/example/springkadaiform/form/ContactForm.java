package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactForm {

    // お名前：未入力NG
    @NotBlank(message = "お名前を入力してください。")
    private String name;

    // メール：未入力NG + メール形式チェック
    @NotBlank(message = "メールアドレスを入力してください。")
    @Email(message = "正しいメールアドレスを入力してください。")
    private String email;

    // メッセージ：未入力NG
    @NotBlank(message = "お問い合わせ内容を入力してください。")
    private String message;
}
