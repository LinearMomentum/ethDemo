package com.example.demo.web.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Scores_sol_Scores2 extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610304806100616000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806376dd110f146100515780638da5cb5b146100a9578063b4d8f80d146100dd578063d119db4c14610135575b600080fd5b6100936004803603602081101561006757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610199565b6040518082815260200191505060405180910390f35b6100b16101b1565b604051808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61011f600480360360208110156100f357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506101d7565b6040518082815260200191505060405180910390f35b6101816004803603604081101561014b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061021f565b60405180821515815260200191505060405180910390f35b60006020528060005260406000206000915090505481565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156102c357816000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550600190506102c8565b600090505b9291505056fea264697066735822122004d0fb07e0420b8d96a7f5cefb99bcf067d9d2267bac67ef66f362ad195b279664736f6c63430007050033\r\n"
            + "\t";

    public static final String FUNC_ADDSCORE = "addScore";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_QUERYSCORE = "queryScore";

    public static final String FUNC_SCORES = "scores";

    protected Scores_sol_Scores2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Scores_sol_Scores2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RemoteCall<Scores_sol_Scores2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Scores_sol_Scores2.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Scores_sol_Scores2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Scores_sol_Scores2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public RemoteCall<TransactionReceipt> addScore(Address addr, Uint256 score) {
        final Function function = new Function(
                FUNC_ADDSCORE, 
                Arrays.<Type>asList(addr, score), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> owner() {
        final Function function = new Function(
                FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> queryScore(Address addr) {
        final Function function = new Function(
                FUNC_QUERYSCORE, 
                Arrays.<Type>asList(addr), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> scores(Address param0) {
        final Function function = new Function(
                FUNC_SCORES, 
                Arrays.<Type>asList(param0), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static Scores_sol_Scores2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Scores_sol_Scores2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Scores_sol_Scores2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Scores_sol_Scores2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
