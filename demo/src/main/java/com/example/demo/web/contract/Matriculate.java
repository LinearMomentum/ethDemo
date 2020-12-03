package com.example.demo.web.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
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
public class Matriculate extends Contract {
    public static final String BINARY = "60806040523480156100115760006000fd5b505b33600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550603c420160016000508190909055505b610069565b610d9e806100786000396000f3fe60806040523480156100115760006000fd5b506004361061008d5760003560e01c80638c17d6661161005c5780638c17d6661461020e5780638da5cb5b14610218578063bbca524e1461024c578063d7856b861461029b5761008d565b806307dc1ce11461009357806369e79e50146100eb5780636b62b80e1461014457806375f890ab146101c95761008d565b60006000fd5b6100c0600480360360208110156100aa5760006000fd5b81019080803590602001909291905050506102f2565b6040518085815260200184815260200183815260200182815260200194505050505060405180910390f35b61012e600480360360208110156101025760006000fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610389565b6040518082815260200191505060405180910390f35b6101716004803603602081101561015b5760006000fd5b81019080803590602001909291905050506103dd565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156101b55780820151818401525b602081019050610199565b505050509050019250505060405180910390f35b61020c600480360360208110156101e05760006000fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610489565b005b6102166104ce565b005b610220610be2565b604051808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610299600480360360408110156102635760006000fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c08565b005b6102f0600480360360a08110156102b25760006000fd5b810190808035906020019092919080359060200190929190803590602001909291908035906020019092919080359060200190929190505050610c89565b005b6000600060006000610302610d3d565b600360005060008781526020019081526020016000206000506040518060800160405290816000820160005054815260200160018201600050548152602001600282016000505481526020016003820160005054815260200150509050806000015181602001518260400151836060015194509450945094505061038256505b9193509193565b6000600560005060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000505490506103d8565b919050565b60606006600050600083815260200190815260200160002060005080548060200260200160405190810160405280929190818152602001828054801561047857602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001906001019080831161042e575b50505050509050610484565b919050565b80600860006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b6000600090505b600260005080549050811015610bde57600460005060006002600050838154811015156104fe57fe5b906000526020600020900160005b50548152602001908152602001600020600050805490506003600050600060026000508481548110151561053c57fe5b906000526020600020900160005b50548152602001908152602001600020600050600201600050541015156107b7576000600090505b6004600050600060026000508481548110151561058b57fe5b906000526020600020900160005b50548152602001908152602001600020600050805490508110156107b5576002600050828154811015156105c957fe5b906000526020600020900160005b505460056000506000600460005060006002600050878154811015156105f957fe5b906000526020600020900160005b505481526020019081526020016000206000508481548110151561062757fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600050819090905550600660005060006002600050848154811015156106b057fe5b906000526020600020900160005b50548152602001908152602001600020600050600460005060006002600050858154811015156106ea57fe5b906000526020600020900160005b505481526020019081526020016000206000508281548110151561071857fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060018154018082558091505060019003906000526020600020900160005b9091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b8080600101915050610572565b505b6000600090505b600460005060006002600050848154811015156107d757fe5b906000526020600020900160005b50548152602001908152602001600020600050805490508110801561084957506003600050600060026000508481548110151561081e57fe5b906000526020600020900160005b505481526020019081526020016000206000506002016000505481105b15610bcf576003600050600060026000508481548110151561086757fe5b906000526020600020900160005b5054815260200190815260200160002060005060030160005054600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b4d8f80d600460005060006002600050878154811015156108e657fe5b906000526020600020900160005b505481526020019081526020016000206000508481548110151561091457fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b15801561098c5760006000fd5b505afa1580156109a1573d600060003e3d6000fd5b505050506040513d60208110156109b85760006000fd5b8101908080519060200190929190505050101515610bc1576002600050828154811015156109e257fe5b906000526020600020900160005b50546005600050600060046000506000600260005087815481101515610a1257fe5b906000526020600020900160005b5054815260200190815260200160002060005084815481101515610a4057fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060005081909090555060066000506000600260005084815481101515610ac957fe5b906000526020600020900160005b5054815260200190815260200160002060005060046000506000600260005085815481101515610b0357fe5b906000526020600020900160005b5054815260200190815260200160002060005082815481101515610b3157fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060018154018082558091505060019003906000526020600020900160005b9091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b80806001019150506107be565b505b80806001019150506104d5565b505b565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6004600050600083815260200190815260200160002060005081908060018154018082558091505060019003906000526020600020900160005b9091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5050565b600260005085908060018154018082558091505060019003906000526020600020900160005b90919091909150909055604051806080016040528085815260200184815260200183815260200182815260200150600360005060008781526020019081526020016000206000506000820151816000016000509090556020820151816001016000509090556040820151816002016000509090556060820151816003016000509090559050505b5050505050565b604051806080016040528060008152602001600081526020016000815260200160008152602001509056fea264697066735822122077728604d6c906799a62f6ca2c985f2a87c0acdbfce8512cb9b88f3bec1d7e4664736f6c63430007050033";

    public static final String FUNC_ADDMAJOR = "addMajor";

    public static final String FUNC_MATRICULATE = "matriculate";

    public static final String FUNC_MATRICULATEDLIST = "matriculatedList";

    public static final String FUNC_MATRICULATEDMAJOR = "matriculatedMajor";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_QUERYMAJOR = "queryMajor";

    public static final String FUNC_SETCONTRACT = "setContract";

    public static final String FUNC_VOLUTEER = "voluteer";

    @Deprecated
    protected Matriculate(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Matriculate(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Matriculate(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Matriculate(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addMajor(BigInteger id, BigInteger uid, BigInteger mid, BigInteger num, BigInteger score) {
        final Function function = new Function(
                FUNC_ADDMAJOR, 
                Arrays.<Type>asList(new Uint256(id),
                new Uint256(uid),
                new Uint256(mid),
                new Uint256(num),
                new Uint256(score)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> matriculate() {
        final Function function = new Function(
                FUNC_MATRICULATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> matriculatedList(BigInteger id) {
        final Function function = new Function(FUNC_MATRICULATEDLIST, 
                Arrays.<Type>asList(new Uint256(id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> matriculatedMajor(String addr) {
        final Function function = new Function(FUNC_MATRICULATEDMAJOR, 
                Arrays.<Type>asList(new Address(160, addr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>> queryMajor(BigInteger id) {
        final Function function = new Function(FUNC_QUERYMAJOR, 
                Arrays.<Type>asList(new Uint256(id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> setContract(String contractAddr) {
        final Function function = new Function(
                FUNC_SETCONTRACT, 
                Arrays.<Type>asList(new Address(160, contractAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> volunteer(BigInteger id, String addr) {
        final Function function = new Function(
                FUNC_VOLUTEER, 
                Arrays.<Type>asList(new Uint256(id),
                new Address(160, addr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Matriculate load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Matriculate(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Matriculate load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Matriculate(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Matriculate load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Matriculate(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Matriculate load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Matriculate(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Matriculate> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Matriculate.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Matriculate> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Matriculate.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Matriculate> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Matriculate.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Matriculate> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Matriculate.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
