package com.company.sakila.db0.sakila.rental.generated;

import com.company.sakila.db0.sakila.rental.Rental;
import com.company.sakila.db0.sakila.rental.RentalImpl;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.injector.annotation.ExecuteBefore;
import com.speedment.common.injector.annotation.WithState;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.sql.SqlPersistenceComponent;
import com.speedment.runtime.core.component.sql.SqlStreamSupplierComponent;
import com.speedment.runtime.core.exception.SpeedmentException;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.speedment.common.injector.State.RESOLVED;

/**
 * The generated Sql Adapter for a {@link
 * com.company.sakila.db0.sakila.rental.Rental} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedRentalSqlAdapter {
    
    private final TableIdentifier<Rental> tableIdentifier;
    
    protected GeneratedRentalSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("db0", "sakila", "rental");
    }
    
    @ExecuteBefore(RESOLVED)
    void installMethodName(@WithState(RESOLVED) SqlStreamSupplierComponent streamSupplierComponent, @WithState(RESOLVED) SqlPersistenceComponent persistenceComponent) {
        streamSupplierComponent.install(tableIdentifier, this::apply);
        persistenceComponent.install(tableIdentifier);
    }
    
    protected Rental apply(ResultSet resultSet) throws SpeedmentException {
        final Rental entity = createEntity();
        try {
            entity.setRentalId(    resultSet.getInt(1)       );
            entity.setRentalDate(  resultSet.getTimestamp(2) );
            entity.setInventoryId( resultSet.getInt(3)       );
            entity.setCustomerId(  resultSet.getInt(4)       );
            entity.setReturnDate(  resultSet.getTimestamp(5) );
            entity.setStaffId(     resultSet.getShort(6)     );
            entity.setLastUpdate(  resultSet.getTimestamp(7) );
        } catch (final SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    protected RentalImpl createEntity() {
        return new RentalImpl();
    }
}