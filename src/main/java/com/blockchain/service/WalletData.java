package com.blockchain.service;

import com.blockchain.model.Wallet;
import com.blockchain.state.BlockchainState;
import lombok.Getter;

import java.security.PrivateKey;
import java.security.PublicKey;

public class WalletData {

    // singleton class
    @Getter
    private static final WalletData instance;

    static {
        instance = new WalletData();
    }

    @Getter
    private Wallet wallet;

    // This will load your wallet from the database.
    public void loadWallet() throws Exception {
        PublicKey pub2 = BlockchainState.getWallets().getLast().getPublicKey();
        PrivateKey prv2 = BlockchainState.getWallets().getLast().getPrivateKey();
        this.wallet = new Wallet(pub2, prv2);
    }

}
