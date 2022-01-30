package utils.delegates;
import java.sql.SQLException;

@FunctionalInterface
public interface DelegateReturnWithTwoParametersThrowsSQLException <R, P1, P2> {
    public R Execute(P1 parameter2, P2 parameter1) throws SQLException;
}