package ma.fstt.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO extends BaseDao<Etudiant>{
    public EtudiantDAO() throws SQLException, ClassNotFoundException {
        super();
    }

    @Override
    public void save(Etudiant object) throws SQLException {

        String request = "insert into etudiant (nom , prenom ,age) values (? , ? , ?)";

        this.preparedStatement = this.mycnx.prepareStatement(request);
        // MOR mapping obeject relation
        this.preparedStatement.setString(1 ,object.getNom() );
        this.preparedStatement.setString(2 ,object.getPrenom() );
        this.preparedStatement.setInt(3 ,object.getAge() );

        this.preparedStatement.execute();
    }

    @Override
    public void update(Etudiant object) throws SQLException {

    }

    @Override
    public void delete(Etudiant object) throws SQLException {

    }

    @Override
    public Etudiant getOne(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Etudiant> getAll() throws SQLException {

        List<Etudiant> mylist = new ArrayList<>();
        String request = "select * from etudiant";
        this.statement = this.mycnx.createStatement();

        this.resultset = this.statement.executeQuery(request);


        while (this.resultset.next()){

            mylist.add(new Etudiant(this.resultset.getLong(1) , this.resultset.getString(2)
                    ,   this.resultset.getString(3), this.resultset.getInt(4)));
        }
        return mylist;
    }
}
