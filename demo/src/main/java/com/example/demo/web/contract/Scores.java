package com.example.demo.web.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Scores extends Contract {
    private static final String BINARY = "60806040523480156100115760006000fd5b505b33600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b61005a565b61032e806100696000396000f3fe60806040523480156100115760006000fd5b50600436106100515760003560e01c806376dd110f146100575780638da5cb5b146100b0578063b4d8f80d146100e4578063d119db4c1461013d57610051565b60006000fd5b61009a6004803603602081101561006e5760006000fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506101a2565b6040518082815260200191505060405180910390f35b6100b86101bd565b604051808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610127600480360360208110156100fb5760006000fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506101e3565b6040518082815260200191505060405180910390f35b61018a600480360360408110156101545760006000fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061023c565b60405180821515815260200191505060405180910390f35b60006000506020528060005260406000206000915090505481565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600060005060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000505490508050809050610237565b919050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156102e95781600060005060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600050819090905550600190506102f2565b600090506102f2565b9291505056fea264697066735822122059c606bda48834c5f3f1238acbba4f93ffd76d949fa53218eca391f51e8a64c364736f6c63430007050033";

    public static final String FUNC_ADDSCORE = "addScore";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_QUERYSCORE = "queryScore";

    public static final String FUNC_SCORES = "scores";

    protected Scores(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Scores(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RemoteCall<Scores> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Scores.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Scores> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Scores.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public RemoteCall<Boolean> addScore(String addr, long score) {
        final Function function = new Function(
                FUNC_ADDSCORE, 
                Arrays.<Type>asList(new Address(addr),
                new Uint256(score)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
                }));
        return executeRemoteCallSingleValueReturn(function,Boolean.class);

    }

    public RemoteCall<TransactionReceipt> owner() {
        final Function function = new Function(
                FUNC_OWNER,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> queryScore(String addr) {
        final Function function = new Function(
                FUNC_QUERYSCORE,
                Arrays.<Type>asList(new Address(addr)),

                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function,BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> scores(String param0) {
        final Function function = new Function(
                FUNC_SCORES,
                Arrays.<Type>asList(new Address(param0)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static Scores load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Scores(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Scores load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Scores(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
