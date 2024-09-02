package com.recommendation.stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Adviser")
@Builder
@Table(name="adviser")
public class Adviser {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="name")
    public String name;

    @Column(name="telegram_id")
    private String telegramId;

    @Column(name="instagram_id")
    private String instagramId;

    @Column(name="youtube_id")
    private String youtubeId;

    @Column(name="contact")
    private String contact;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="instagram_ratings")
    private String instagramRatings;

    @Column(name="telegram_ratings")
    private String telegramRatings;

    @Column(name="youtube_ratings")
    private String youtubeRatings;

    @Column(name="ratings")
    private String ratings;

    @Column(name="status")
    private String status;

    @Column(name="type")
    private String type;

    @Column(name="website_link")
    private String websiteLink;

}
