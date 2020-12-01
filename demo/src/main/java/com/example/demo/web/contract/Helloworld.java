package com.example.demo.web.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Helloworld extends Contract {
    private static final String BINARY = "60806040526040518060400160405280600a81526020017f68656c6c6f776f726c640000000000000000000000000000000000000000000081526020015060006000509080519060200190610055929190610069565b503480156100635760006000fd5b5061011f565b828054600181600116156101000203166002900490600052602060002090601f01602090048101928261009f57600085556100eb565b82601f106100b857805160ff19168380011785556100eb565b828001600101855582156100eb579182015b828111156100ea57825182600050909055916020019190600101906100ca565b5b5090506100f891906100fc565b5090565b610101565b8082111561011b5760008181506000905550600101610101565b5090565b61019a8061012e6000396000f3fe60806040523480156100115760006000fd5b50600436106100305760003560e01c8063cc80f6f31461003657610030565b60006000fd5b61003e6100ba565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561007f5780820151818401525b602081019050610063565b50505050905090810190601f1680156100ac5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b606060006000508054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156101555780601f1061012a57610100808354040283529160200191610155565b820191906000526020600020905b81548152906001019060200180831161013857829003601f168201915b50505050509050610161565b9056fea264697066735822122005eecb2261fabb6c0943e5be34ace46335dfd55135c1483cea504ff39ec5dcc064736f6c63430007050033";

    public static final String FUNC_SHOW = "show";

    protected Helloworld(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Helloworld(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }


    public RemoteCall<String> show() {
        final Function function = new Function(
                FUNC_SHOW,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }));
        return executeRemoteCallSingleValueReturn(function,String.class);
    }

    public static RemoteCall<Helloworld> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Helloworld.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Helloworld> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Helloworld.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Helloworld load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Helloworld(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Helloworld load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Helloworld(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
