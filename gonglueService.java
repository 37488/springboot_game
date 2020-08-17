package com.game.service;

import com.game.entity.Game;
import com.game.entity.Page;
import com.game.mapper.gonglueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class gonglueService {
    @Autowired
    private com.game.mapper.gonglueMapper gonglueMapper;

    public List<Game> selectAll() {
        return gonglueMapper.selectAll();
    }


    public List<Game> selectListByPage(Integer current, Integer size) {
        return gonglueMapper.selectListByPage(new Page(current, size));
    }


    public List<Game> searchListByPage(Page page, String word) {
        return gonglueMapper.searchListByPage(page, word);
    }

    public Page selectPage() {
        return gonglueMapper.selectPage();
    }

    public Page searchPage(String word) {
        return gonglueMapper.searchPage(word);
    }

    public Game selectOneByMid(Integer mid) {
        return gonglueMapper.selectOneByMid(mid);
    }
}
