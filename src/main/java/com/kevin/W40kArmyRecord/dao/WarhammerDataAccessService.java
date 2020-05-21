package com.kevin.W40kArmyRecord.dao;

import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.model.Faction;
import com.kevin.W40kArmyRecord.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class WarhammerDataAccessService implements WarhammerDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WarhammerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertFaction(Faction faction) {
        final String sql = "INSERT INTO faction (faction_name) VALUES (?)";
        return jdbcTemplate.update(
                sql,
                faction.getFactionName()
        );
    }
    @Override
    public int insertArmy(Army army) {
        final String sql = "INSERT INTO army (faction_id, army_name) VALUES (?,?)";
        return jdbcTemplate.update(
                sql,
                army.getFactionId(),
                army.getArmyName()
        );
    }
    @Override
    public int insertUnit(Unit unit) {
        final String sql = "INSERT INTO unit (army_id, unit_name) VALUES (?,?)";
        return jdbcTemplate.update(
                sql,
                unit.getArmy_id(),
                unit.getUnit_name()
        );
    }


    @Override
    public List<Faction> selectAllFactions() {
        final String sql = "SELECT faction_id, faction_name FROM faction";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("faction_id"));
            String name = resultSet.getString("faction_name");
            return new Faction(id, name);
        });
    }
    @Override
    public List<Army> selectAllArmies() {
        final String sql = "SELECT army_id, faction_id, army_name FROM army";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int idA = Integer.parseInt(resultSet.getString("army_id"));
            int idF = Integer.parseInt(resultSet.getString("faction_id"));
            String name = resultSet.getString("army_name");
            return new Army(idA, idF, name);
        });
    }
    @Override
    public List<Unit> selectAllUnits() {
        final String sql = "SELECT unit_id, army_id, unit_name FROM unit";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int idU = Integer.parseInt(resultSet.getString("unit_id"));
            int idA = Integer.parseInt(resultSet.getString("army_id"));
            String name = resultSet.getString("unit_name");
            return new Unit(idU, idA, name);
        });
    }


    @Override
    public Optional<Faction> selectFactionById(int id) {
        final String sql = "SELECT faction_id, faction_name FROM faction WHERE faction_id = ?";
        Faction faction = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int faction_id = Integer.parseInt(resultSet.getString("faction_id"));
                    String name = resultSet.getString("faction_name");
                    return new Faction(faction_id, name);
                });
        return Optional.ofNullable(faction);
    }
    @Override
    public Optional<Army> selectArmyById(int id) {
        final String sql = "SELECT army_id, faction_id, army_name FROM army WHERE army_id = ?";
        Army army = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int army_id = Integer.parseInt(resultSet.getString("army_id"));
                    int faction_id = Integer.parseInt(resultSet.getString("faction_id"));
                    String name = resultSet.getString("army_name");
                    return new Army(army_id, faction_id, name);
                }
        );
        return Optional.ofNullable(army);
    }
    @Override
    public Optional<Unit> selectUnitById(int id) {
        final String sql = "SELECT unit_id, army_id, unit_name FROM unit WHERE unit_id = ?";
        Unit unit = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int unit_id = Integer.parseInt(resultSet.getString("unit_id"));
                    int army_id = Integer.parseInt(resultSet.getString("army_id"));
                    String name = resultSet.getString("unit_name");
                    return new Unit(unit_id, army_id, name);
                }
        );
        return Optional.ofNullable(unit);
    }


    @Override
    public int deleteFactionById(int id) {
        final String sql = "DELETE FROM faction WHERE faction_id = ?";
        return jdbcTemplate.update(sql, id);
    }
    @Override
    public int deleteArmyById(int id) {
        final String sql = "DELETE FROM army WHERE army_id = ?";
        return jdbcTemplate.update(sql, id);
    }
    @Override
    public int deleteUnitById(int id) {
        final String sql = "DELETE FROM unit WHERE unit_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateFactionById(int id, Faction faction) {
        final String sql = "UPDATE FROM faction WHERE faction_id = ?";
        return jdbcTemplate.update(sql, id, faction);
    }
    @Override
    public int updateArmyById(int id, Army army) {
        final String sql = "UPDATE FROM army WHERE army_id = ?";
        return jdbcTemplate.update(sql, id, army);
    }
    @Override
    public int updateUnitById(int id, Unit unit) {
        final String sql = "UPDATE FROM unit WHERE unit_id = ?";
        return jdbcTemplate.update(sql, id, unit);
    }
}
