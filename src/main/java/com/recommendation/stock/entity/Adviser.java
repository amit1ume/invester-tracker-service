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

    @Column(name="telegramId")
    private String telegramId;

    @Column(name="instagramId")
    private String instagramId;

    @Column(name="youtubeId")
    private String youtubeId;

    @Column(name="contact")
    private String contact;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;


    @Column(name="instagramRatings")
    private String instagramRatings;

    @Column(name="telegramRatings")
    private String telegramRatings;

    @Column(name="youtubeRatings")
    private String youtubeRatings;

    @Column(name="ratings")
    private String ratings;

    @Column(name="status")
    private String status;

    @Column(name="type")
    private String type;

    @Column(name="websiteLink")
    private String websiteLink;

}
