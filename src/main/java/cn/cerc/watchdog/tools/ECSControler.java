package cn.cerc.watchdog.tools;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse.Instance;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.ecs.model.v20140526.*;

public class ECSControler {
	private static final String ak = "";
	private static final String aks = "";
	private IClientProfile profile;
	private IAcsClient client;

	public ECSControler() {
		profile = DefaultProfile.getProfile("cn-hongkong", ak, aks);
		client = new DefaultAcsClient(profile);
	}

	/**
	 * 列出所有的实例
	 */
	public void list() {
		DescribeInstancesRequest request = new DescribeInstancesRequest();
		DescribeInstancesResponse response;
		try {
			response = client.getAcsResponse(request);
			for (Instance instance : response.getInstances()) {
				System.out.println(instance.getInstanceId());
			}
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重启ECS
	 * 
	 * @param instanceId
	 */
	public void reset(String instanceId) {
		try {
			RebootInstanceRequest req = new RebootInstanceRequest();
			req.setInstanceId(instanceId);
			req.setActionName("RebootInstance");
			req.setForceStop(false);
			RebootInstanceResponse resp = client.getAcsResponse(req);
			System.out.println(resp.getRequestId());
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		ECSControler ecs = new ECSControler();
//		ecs.reset("i-j6c2ct08gslpbxsxkqwo");
	}
}
