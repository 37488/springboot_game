package com.game.mapper;

import com.game.entity.Game;
import com.game.entity.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface gonglueMapper {
    @Select("select * from Game")
    List<Game> selectAll();

    @Select("select * from Game limit #{startOffset},#{size}")
    List<Game> selectListByPage(Page page);


    @Select("select * from Game where Gamename like concat('%',#{word},'%') like concat('%',#{word},'%') limit #{page.startOffset},#{page.size}")
    List<Game> searchListByPage(@Param("page") Page page, @Param("word") String word);

    //获取总的数量
    @Select("select count(Gameid) as totalNumber from Game")
    Page selectPage();

    @Select("select count(Gameid) as totalNumber from Game  where Gamename like concat('%',#{word},'%') like concat('%',#{word},'%')")
    Page searchPage(String word);

    @Select("select * from Game where Gameid=#{Gameid}")
    Game selectOneByMid(Integer Gameid);
}
