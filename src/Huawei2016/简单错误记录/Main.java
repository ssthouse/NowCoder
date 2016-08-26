package Huawei2016.简单错误记录;

import java.util.*;
import java.lang.System;

/**
 * 结果应该是正确了   但是因为输入原因  无法在  在线编辑器跑⊙︿⊙
 *
 * 描述:
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 * <p>
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * <p>
 * 文件路径为windows格式
 * <p>
 * 如：E:\V1R2\product\fpgadrive.c 1325
 * <p>
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 * <p>
 * 结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
 * <p>
 * 如果超过8条记录，则只输出前8条记录.
 * <p>
 * 如果文件名的长度超过16个字符，则只输出后16个字符
 * <p>
 * 输入例子:
 * E:\V1R2\product\fpgadrive.c 1325
 * <p>
 * 输出例子:
 * fpgadrive.c 1325 1
 * Created by ssthouse on 16/6/26.
 */
public class Main {

    private static class ErrorBean {
        //出现的顺序
        int indexOfError;

        String fileName;
        int errorLine;
        int errorNum;

        ErrorBean(int indexOfError, String fileName, int errorLine) {
            this.indexOfError = indexOfError;
            this.fileName = fileName;
            this.errorLine = errorLine;
            errorNum = 0;
        }

        void addErrorNum() {
            errorNum++;
        }

        @Override
        public String toString() {
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16 , fileName.length()-1);
            }
            return fileName + " " + errorLine + " " + errorNum;
        }
    }

    public static void main(String[] args) {
        //循环读取每一行错误信息
        int errorIndex = 0;
        HashMap<String, ErrorBean> errorMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String currentLine = scanner.nextLine();
        while (!currentLine.equals("")) {
            String filePath = currentLine.split(" ")[0];
            String fileName = filePath.split("\\\\")[filePath.split("\\\\").length - 1];
            int errorLine = Integer.parseInt(currentLine.split(" ")[1]);
            System.out.println(fileName + errorLine);

            //使用fileName+errorLine 作为  key   获取 HashMap里面的ErrorBean
            //  如果没有  添加新的ErrorBean
            //  如果有    修改ErrorBean
            ErrorBean errorBean = errorMap.get(fileName + errorLine);
            if (errorBean == null) {
                errorBean = new ErrorBean(errorIndex, fileName, errorLine);
                errorBean.addErrorNum();
                //出现序号加一
                errorIndex++;
                //加入map
                errorMap.put(fileName + errorLine, errorBean);
            } else {
                errorBean.addErrorNum();
            }

            //更新currentLine
            currentLine = scanner.nextLine();
        }

        //将HashMap中的数据拿出  进行排序   放入List中
        List<ErrorBean> errorBeanList = new ArrayList<>();
        for (Map.Entry<String, ErrorBean> entry : errorMap.entrySet()) {
            errorBeanList.add(entry.getValue());
        }
        for (int i = 0; i < errorBeanList.size() - 1; i++) {
            for (int j = 0; j < errorBeanList.size() - i - 1; j++) {
                if (errorBeanList.get(j).errorNum < errorBeanList.get(j + 1).errorNum) {
                    //交换
                    ErrorBean tempBean = errorBeanList.get(j);
                    errorBeanList.set(j, errorBeanList.get(j + 1));
                    errorBeanList.set(j + 1, tempBean);
                } else if (errorBeanList.get(j).errorNum == errorBeanList.get(j + 1).errorNum
                        && errorBeanList.get(j).indexOfError > errorBeanList.get(j + 1).indexOfError) {

                    //交换
                    ErrorBean tempBean = errorBeanList.get(j);
                    errorBeanList.set(j, errorBeanList.get(j + 1));
                    errorBeanList.set(j + 1, tempBean);
                }
            }
        }
        //遍历结束
        for (ErrorBean errorBean : errorBeanList) {
            System.out.println(errorBean.toString());
        }
    }
}
