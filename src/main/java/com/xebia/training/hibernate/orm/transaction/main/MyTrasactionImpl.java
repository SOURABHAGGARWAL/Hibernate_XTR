package com.xebia.training.hibernate.orm.transaction.main;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.engine.transaction.spi.TransactionCoordinator;
import org.hibernate.engine.transaction.spi.TransactionImplementor;

public class MyTrasactionImpl implements org.hibernate.engine.transaction.spi.TransactionFactory{

	@Override
	public TransactionImplementor createTransaction(
			TransactionCoordinator coordinator) {
		return null;
	}

	@Override
	public boolean canBeDriver() {
		return false;
	}

	@Override
	public boolean compatibleWithJtaSynchronization() {
		return false;
	}

	@Override
	public boolean isJoinableJtaTransaction(
			TransactionCoordinator transactionCoordinator,
			TransactionImplementor transaction) {
		return false;
	}

	@Override
	public ConnectionReleaseMode getDefaultReleaseMode() {
		return null;
	}

}
