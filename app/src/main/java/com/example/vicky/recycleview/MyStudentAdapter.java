package com.example.vicky.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

//here adapter doesnot extends baseadapter as in before
//here it extends recyclerview
//MyviewHolder is new Student class as we know. Just being initialized

public class MyStudentAdapter extends RecyclerView.Adapter<MyStudentAdapter.MyViewHolder> {

    //we initialise here whatever is require here. Example here we require Student arraylist and context. so initialize them from any other page whereever they are built
    //either we can make our own variables or can take from others. the variables or arraylist or context

    private ArrayList<Student> studentArrayList;
    private Context context;          //of course context is required SINCE ITS not in the same main activity. so to use inflate we need context.


    //constructor

    public MyStudentAdapter(ArrayList<Student> students, Context ctx) {
        studentArrayList = students;
        context = ctx;
    }


    //for view holder more in detail see in lecture 5 video lecture
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater lif = LayoutInflater.from(context);
        View inflatedView = lif.inflate(R.layout.item_row,parent,false);  //here item_row.xml is attached to adapter. however mainactivity is always connected.
        return new MyViewHolder(inflatedView);
    }

    //here binding and holding process is done

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student currentStudent = studentArrayList.get(position);
        holder.name.setText(currentStudent.getName());
        holder.location.setText(currentStudent.getLocation());
        holder.batch.setText(currentStudent.getBatch());
        holder.number.setText(currentStudent.getNumber());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    //making a new viewholder class so that its recycle view type list and takes less memory usage.

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,number,batch,location;
        Button btn;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studentName);
            number = itemView.findViewById(R.id.studentNumber);
            batch = itemView.findViewById(R.id.studentBatch);
            location = itemView.findViewById(R.id.studentLocation);
            btn = itemView.findViewById(R.id.idBtn);
        }
    }

}
