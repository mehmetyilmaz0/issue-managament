package com.mehmetyilmaz.issuemanagement.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

// spring in Page nesnesi ile degil kendi yazdigimiz TPage nesnesi ile disari ile konusacagim.
// Modelmapper ile paginening islemi farkli olmasi gerektigi icin.
public class TPage<T> {

    private int number;             // suan kacinci sayfa gorunuyor
    private int size;               // kayitlari kacarli gormek istiyoruz onyuzde
    private Sort sort;              // herhangi bir kolona tiklayip o kolonu siralamak icin
    private int totalPages;         // toplam kac tane sayfa olustu
    private Long totalElements;     // toplamda kac kayit var
    private List<T> content;        // donecegim datayi gosterilecek

    public void setStat (Page page, List<T> list) {
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;
    }

}
