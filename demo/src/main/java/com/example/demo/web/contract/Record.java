package com.example.demo.web.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class Record extends Contract {
    public static final String BINARY = "60806040523480156100115760006000fd5b505b33600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b61005a565b6109f2806100696000396000f3fe60806040523480156100115760006000fd5b50600436106100675760003560e01c80630f5ceb111461006d57806366858ec81461009d57806378f508c0146100cd5780637a261934146100fd5780638da5cb5b1461012d578063a33c4df11461014b57610067565b60006000fd5b6100876004803603810190610082919061061e565b61017b565b60405161009491906107c1565b60405180910390f35b6100b760048036038101906100b29190610649565b610257565b6040516100c491906107a5565b60405180910390f35b6100e760048036038101906100e291906106a1565b610381565b6040516100f49190610789565b60405180910390f35b610117600480360381019061011291906106a1565b6103d1565b6040516101249190610789565b60405180910390f35b61013561041f565b6040516101429190610789565b60405180910390f35b6101656004803603810190610160919061061e565b610445565b60405161017291906107c1565b60405180910390f35b6060600060005060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060005080546101cd906108f7565b80601f01602080910402602001604051908101604052809291908181526020018280546101f9906108f7565b80156102465780601f1061021b57610100808354040283529160200191610246565b820191906000526020600020905b81548152906001019060200180831161022957829003601f168201915b50505050509050610252565b919050565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156103725781600060005060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060005090805190602001906103089291906104e8565b508260016000508360405161031d9190610771565b908152602001604051809103902060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001905061037b565b6000905061037b565b92915050565b60006001600050826040516103969190610771565b908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690506103cc565b919050565b60016000508180516020810182018051848252602083016020850120818352809550505050505060009150909054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60006000506020528060005260406000206000915090508054610467906108f7565b80601f0160208091040260200160405190810160405280929190818152602001828054610493906108f7565b80156104e05780601f106104b5576101008083540402835291602001916104e0565b820191906000526020600020905b8154815290600101906020018083116104c357829003601f168201915b505050505081565b8280546104f4906108f7565b90600052602060002090601f0160209004810192826105165760008555610562565b82601f1061052f57805160ff1916838001178555610562565b82800160010185558215610562579182015b828111156105615782518260005090905591602001919060010190610541565b5b50905061056f9190610573565b5090565b610578565b808211156105925760008181506000905550600101610578565b5090566109bb565b60006105ad6105a884610816565b6107e4565b9050828152602081018484840111156105c65760006000fd5b6105d18482856108b2565b505b9392505050565b6000813590506105e9816109a0565b5b92915050565b600082601f83011215156106045760006000fd5b813561061484826020860161059a565b9150505b92915050565b6000602082840312156106315760006000fd5b600061063f848285016105da565b9150505b92915050565b600060006040838503121561065e5760006000fd5b600061066c858286016105da565b925050602083013567ffffffffffffffff81111561068a5760006000fd5b610696858286016105f0565b9150505b9250929050565b6000602082840312156106b45760006000fd5b600082013567ffffffffffffffff8111156106cf5760006000fd5b6106db848285016105f0565b9150505b92915050565b6106ee81610871565b82525b5050565b6106fe81610884565b82525b5050565b600061071082610847565b61071a8185610853565b935061072a8185602086016108c2565b6107338161098e565b84019150505b92915050565b600061074a82610847565b6107548185610865565b93506107648185602086016108c2565b8084019150505b92915050565b600061077d828461073f565b91508190505b92915050565b600060208201905061079e60008301846106e5565b5b92915050565b60006020820190506107ba60008301846106f5565b5b92915050565b600060208201905081810360008301526107db8184610705565b90505b92915050565b6000604051905081810181811067ffffffffffffffff8211171561080b5761080a61095d565b5b80604052505b919050565b600067ffffffffffffffff8211156108315761083061095d565b5b601f19601f83011690506020810190505b919050565b6000815190505b919050565b60008282526020820190505b92915050565b60008190505b92915050565b600061087c82610891565b90505b919050565b600081151590505b919050565b600073ffffffffffffffffffffffffffffffffffffffff821690505b919050565b828183376000838301525b505050565b60005b838110156108e15780820151818401525b6020810190506108c5565b838111156108f0576000848401525b505b505050565b60006002820490506001821680151561091157607f821691505b602082108114156109255761092461092c565b5b505b919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b565b6000601f19601f83011690505b919050565b6109a981610871565b811415156109b75760006000fd5b5b50565bfea2646970667358221220b1ae0a50b902eabae35206cccbf85057a75d92e52be883d0bcd8bd5f7ba7612064736f6c63430008000033";

    public static final String FUNC_ADDRECORD = "addRecord";

    public static final String FUNC_ADDRTOID = "addrToId";

    public static final String FUNC_IDTOADDR = "idToAddr";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_QUERYADDR = "queryAddr";

    public static final String FUNC_QUERYID = "queryId";

    @Deprecated
    protected Record(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Record(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Record(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Record(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addRecord(String addr, String id) {
        final Function function = new Function(
                FUNC_ADDRECORD, 
                Arrays.<Type>asList(new Address(160, addr),
                new Utf8String(id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> addrToId(String param0) {
        final Function function = new Function(FUNC_ADDRTOID, 
                Arrays.<Type>asList(new Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> idToAddr(String param0) {
        final Function function = new Function(FUNC_IDTOADDR, 
                Arrays.<Type>asList(new Utf8String(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> queryAddr(String id) {
        final Function function = new Function(FUNC_QUERYADDR, 
                Arrays.<Type>asList(new Utf8String(id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> queryId(String addr) {
        final Function function = new Function(FUNC_QUERYID, 
                Arrays.<Type>asList(new Address(160, addr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Record load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Record load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Record load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Record(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Record load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Record(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Record> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Record.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Record> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Record.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Record> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Record.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Record> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Record.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
