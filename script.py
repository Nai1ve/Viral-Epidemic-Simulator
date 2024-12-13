import matplotlib.pyplot as plt
import sys
import matplotlib
import datetime
from collections import defaultdict


# 设置中文字体
matplotlib.rcParams['font.family'] = 'STHeiti'  # 或者选择其他中文字体
matplotlib.rcParams['axes.unicode_minus'] = False  # 让负号显示正常

def generate_chart(normal, close_contact, infected, policies):
    plt.figure(figsize=(10, 6))

    # 生成天数列表
    days = list(range(1, len(normal) + 1))

    print("开始绘制图表...")
    try:
        plt.plot(days, normal, label='normal', color='blue')  # 正常人数用蓝色
        plt.plot(days, close_contact, label='close_contact', color='orange')  # 密接人数用橙色
        plt.plot(days, infected, label='infected', color='green')  # 感染人数用绿色
        
        plt.xlabel('days')
        plt.ylabel('number of people')
        plt.title('Viral Epidemic Simulator')

        # 添加政策开启标注
        policy_colors = ['red', 'purple', 'brown', 'cyan']  # 一些颜色供政策使用
        for i, (day, policy) in enumerate(policies.items()):
            plt.axvline(x=day, color=policy_colors[i % len(policy_colors)], linestyle='--')
            plt.text(day, max(max(normal), max(close_contact), max(infected)), f'policy: {policy}', 
                     color=policy_colors[i % len(policy_colors)],
                     horizontalalignment='center', verticalalignment='bottom')

        plt.xticks(days)  # 设置 x 轴为天数
        plt.legend()
        # 生成以日期和时间为前缀的文件名
        date_str = datetime.datetime.now().strftime('%Y-%m-%d_%H-%M')
        filename = f'{date_str}_line_chart.png'
        plt.savefig(filename)
        print(f"图表成功保存为 '{filename}'。")
    except Exception as e:
        print("绘制图表失败:", e)

if __name__ == '__main__':
    # 从命令行参数获取数据
    if len(sys.argv) < 4:
        raise ValueError("参数不足，至少需要三个参数。")
    try:
        print("从命令行参数获取数据...")
        normal = list(map(int, sys.argv[1].split(',')))
        close_contact = list(map(int, sys.argv[2].split(',')))
        infected = list(map(int, sys.argv[3].split(','))) if len(sys.argv) > 3 else []
        
        # 如果存在政策输入，解析政策信息
        policies = defaultdict(list)
        if len(sys.argv) == 5:
            policy_input = sys.argv[4].split(',')
            for policy in policy_input:
                day, description = policy.split(':')
                policies[int(day)].append(description)

        # 合并同一天的政策
        merged_policies = {day: ', '.join(descriptions) for day, descriptions in policies.items()}

        print("数据获取成功。")
        print("合并后的政策信息：", merged_policies)
        print("数据获取成功。")
    except Exception as e:
        print("从命令行参数获取数据失败:", e)
        sys.exit(1)

    generate_chart(normal, close_contact, infected, policies)