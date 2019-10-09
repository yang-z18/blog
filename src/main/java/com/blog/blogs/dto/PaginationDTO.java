package com.blog.blogs.dto;

import com.blog.blogs.model.BlogDTO;

import java.util.ArrayList;
import java.util.List;

public class PaginationDTO{
    public List<BlogDTO> getBlogDTOS() {
        return blogDTOS;
    }

    public void setBlogDTOS(List<BlogDTO> blogDTOS) {
        this.blogDTOS = blogDTOS;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowFirstPage() {
        return showFirstPage;
    }

    public void setShowFirstPage(boolean showFirstPage) {
        this.showFirstPage = showFirstPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    private List<BlogDTO> blogDTOS;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages  = new ArrayList<>();
    private Integer totalPage;
    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.totalPage=totalPage;
        this.page=page;
        if (totalCount%size==0){
            totalPage=totalCount/size;
        }else {
            totalPage=totalCount/size+1;
        }
        if (page<1){
            page=1;
        }
        if (page>totalPage){
            page=totalPage;
        }
        pages.add(page);
        for(int i=1;i<=3;i++){
            if(page-i>0){
                pages.add(0,page-i);
            }
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }

        //是否展示第一页
        if(page==1){
            showPrevious=false;
        }else {
            showPrevious=true;
        }

        //是否展示下一页
        if(page==totalPage){
            showNext=false;
        }else {
            showNext=true;
        }
        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage=false;
        }else {
            showFirstPage=true;
        }

        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage=false;
        }else {
            showEndPage=true;
        }
    }

}
