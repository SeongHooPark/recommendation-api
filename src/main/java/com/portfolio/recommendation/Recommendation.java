package com.portfolio.recommendation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 20, message = "이름은 20자 이내로 입력해주세요.")
    @Column(length = 20)
    private String name;

    @NotBlank(message = "관계를 입력해주세요.")
    @Size(max = 30, message = "관계는 30자 이내로 입력해주세요.")
    @Column(length = 30)
    private String relation;

    @NotBlank(message = "추천 내용을 입력해주세요.")
    @Size(max = 500, message = "추천 내용은 500자 이내로 입력해주세요.")
    @Column(length = 500)
    private String content;

    private LocalDateTime createdAt;

    public Recommendation() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}