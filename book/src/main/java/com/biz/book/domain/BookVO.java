package com.biz.book.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "tbl_book")
public class BookVO {

    // tbl_book 테이블에서 PK키다 라고 알려주는
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 설정을 안해주면 int가 될 수 있기 때문에 너는 BIGINT다 라고 알려주는
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(columnDefinition = "VARCHAR(125)")
    private String title;

    // varchar나 nvarchar가 지정이되고 길이가 30으로 지정해서 30길이
    @Column(length = 30)
    private String author;

    @Column(length = 125)
    private String comp;

    private int price;
}
