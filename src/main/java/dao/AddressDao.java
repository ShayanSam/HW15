package dao;

import entities.Address;

import javax.persistence.EntityManager;

public class AddressDao extends AbstractDao<Address, Long> {

    public AddressDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Address> entityClass() {
        return Address.class;
    }
}
