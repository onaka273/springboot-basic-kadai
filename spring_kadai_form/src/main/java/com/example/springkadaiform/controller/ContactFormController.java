package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    // 入力フォーム表示
    @GetMapping("/contact")
    public String contact(Model model) {
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "contactFormView"; // ← 入力画面
    }

    // 入力確認
    @PostMapping("/contact/confirm")
    public String confirm(@Valid ContactForm form,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            // バリデーションNG → 入力画面に戻る
            return "contactFormView";
        }
        // バリデーションOK → 確認画面へ
        model.addAttribute("contactForm", form);
        return "confirmView"; // ← 確認画面
    }

    // 送信完了
    @PostMapping("/contact/submit")
    public String submit(@Valid ContactForm form,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            // バリデーションNG → 入力画面に戻る
            return "contactFormView";
        }

        // 本来はDB登録やメール送信などの処理を書く
        System.out.println("送信された内容: " + form);

     // 完了画面は使わない → 確認画面にリダイレクト
        return "redirect:/contact/confirm";

    }
}
