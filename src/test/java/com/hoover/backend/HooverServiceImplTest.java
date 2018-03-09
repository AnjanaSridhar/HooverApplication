package com.hoover.backend;

import com.hoover.backend.service.HooverServiceImpl;
import com.hoover.backend.model.CoOrds;
import com.hoover.backend.model.Hoover;
import com.hoover.backend.model.Room;
import com.hoover.backend.service.HooverService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class HooverServiceImplTest {

    private HooverService hooverService;
    private List<CoOrds> dirtPatches;
    private Room room;

    @Before
    public void setUp(){
        hooverService = new HooverServiceImpl();
        room = new Room(new CoOrds(5, 5));
        dirtPatches = new ArrayList<>();
        room.setDirtPatches(dirtPatches);
    }

    @Test
    public void hooverMovement_North(){
        //given
        String direction = "N";
        Hoover hoover = new Hoover(new CoOrds(1,1), 0);

        //when
        hoover = hooverService.startHoover(hoover, room, direction);

        //then
        assertNotNull(hoover);
        assertEquals(2, hoover.getPosition().getY());
        assertEquals(1, hoover.getPosition().getX());
    }

    @Test
    public void hooverMovement_South(){
        //given
        String direction = "S";
        Hoover hoover = new Hoover(new CoOrds(1,1), 0);

        //when
        hoover = hooverService.startHoover(hoover, room, direction);

        //then
        assertNotNull(hoover);
        assertEquals(0, hoover.getPosition().getY());
        assertEquals(1, hoover.getPosition().getX());
    }

    @Test
    public void hooverMovement_West(){
        //given
        String direction = "W";
        Hoover hoover = new Hoover(new CoOrds(1,1), 0);

        //when
        hoover = hooverService.startHoover(hoover, room, direction);

        //then
        assertNotNull(hoover);
        assertEquals(1, hoover.getPosition().getY());
        assertEquals(0, hoover.getPosition().getX());
    }

    @Test
    public void hooverMovement_East(){
        //given
        String direction = "E";
        Hoover hoover = new Hoover(new CoOrds(1,1), 0);

        //when
        hoover = hooverService.startHoover(hoover, room, direction);

        //then
        assertNotNull(hoover);
        assertEquals(1, hoover.getPosition().getY());
        assertEquals(2, hoover.getPosition().getX());
    }

    @Test
    public void hooverClean_Success(){
        //given
        String direction = "NE";
        Hoover hoover = new Hoover(new CoOrds(1,1), 0);
        dirtPatches.add(new CoOrds(1, 2));

        //when
        hoover = hooverService.startHoover(hoover, room, direction);

        //then
        assertNotNull(hoover);
        assertEquals(0, dirtPatches.size());
    }

    @Test
    public void returnCleanPatches(){
        //given
        String direction = "NE";
        Hoover hoover = new Hoover(new CoOrds(1,1), 0);
        dirtPatches.add(new CoOrds(1, 2));
        room.setDirtPatches(dirtPatches);

        //when
        hoover = hooverService.startHoover(hoover, room, direction);

        //then
        assertNotNull(hoover);
        assertEquals(0, room.getDirtPatches().size());
        assertEquals(1, hoover.getCleanedPatches());
    }

    @Test
    public void hooverMovement_EdgeCases_SouthAndWest(){
        //given
        String direction = "SW";
        Hoover hoover = new Hoover(new CoOrds(0,0), 0);

        //when
        hoover = hooverService.startHoover(hoover, room, direction);

        //then
        assertNotNull(hoover);
        assertEquals(0, hoover.getPosition().getY());
        assertEquals(0, hoover.getPosition().getY());
    }

    @Test
    public void hooverMovement_EdgeCases_NortAndEast(){
        //given
        String direction = "NE";
        Hoover hoover = new Hoover(new CoOrds(4,4), 0);

        //when
        hoover = hooverService.startHoover(hoover, room, direction);

        //then
        assertNotNull(hoover);
        assertEquals(4, hoover.getPosition().getY());
        assertEquals(4, hoover.getPosition().getY());
    }
}
