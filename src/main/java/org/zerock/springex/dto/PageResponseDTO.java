package org.zerock.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    //시작 페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        //마지막 페이지 (page를 10으로 나눈 값을 올림 처리 한 후 * 10)
        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;

        //시작 페이지  (마지막 페이지 -9)
        this.start = this.end - 9;

        //total이 75라면 마지막 페이지는 8 따라서 end와 비교
        int last = (int)(Math.ceil((total/(double)size)));

        //마지막 페이지(end)가 last 보다 작으면 last가 end가 되어야 함
        this.end = end > last ? last : end;

        //시작 페이지(start)가 1이 아니면 무조건 true
        this.prev = this.start > 1;

        //다음(next)는 마지막 페이지 와 페이지당 개수를 곱한 값보다 많은지 보기
        this.next = total > this.end * this.size;
    }
}
