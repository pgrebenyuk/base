package base.repository;

import java.sql.SQLException;

public class Articles extends BaseTable implements TableOperations{

    public Articles() throws SQLException {
        super("articles");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE articles(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "article VARCHAR(255) NOT NULL," +
                "price DOUBLE(15,2) NOT NULL DEFAULT 10," +
                "changeProbability INTEGER NOT NULL DEFAULT 25,"
                , "Создана таблица " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
    }

    @Override
    public void createExtraConstraints() throws SQLException {
        super.executeSqlStatement(
                " ALTER TABLE shares ADD CONSTRAINT check_shares_delta CHECK(delta <= 100 and delta > 0)",
                "Cоздано ограничение для shares, поле delta = [1,100]");
        super.executeSqlStatement(
                " ALTER TABLE shares ADD CONSTRAINT check_shares_changeProbability " +
                        "CHECK(changeProbability <= 100 and changeProbability > 0)",
                "Cоздано ограничение для shares, поле changeProbability = 1..100");

    }
}